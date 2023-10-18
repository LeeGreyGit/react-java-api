package gb.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gb.sample.error.CheckUtil;
import gb.sample.error.Message;
import gb.sample.mapper.TodoMapper;
import gb.sample.model.TodoUpdateRequestModel;
import gb.sample.model.Todo;

@Service
public class TodoService {
  @Autowired
  private TodoMapper todoMapper;

  public List<Todo> list() {
    List<Todo> todo = todoMapper.getTodoList();
    return todo;
  }

  /**
   * Update
   *
   * @param requestModel TodoUpdateRequestModel
   * @return
   */
  public ResponseEntity<?> update(TodoUpdateRequestModel requestModel) {

    // 必須チェック
    if (CheckUtil.isEmpty(requestModel.getTitle())) {
      return new ResponseEntity<>(new Message("No input title"), HttpStatus.BAD_REQUEST);
    }
    if (CheckUtil.isEmpty(requestModel.getText())) {
      return new ResponseEntity<>(new Message("No input text"), HttpStatus.BAD_REQUEST);
    }

    if(requestModel.getId() != null){
    // データ取得
    Todo todo = todoMapper.selectTodo(requestModel.getId());

    if (todo == null) {
      return new ResponseEntity<>(new Message("No data found"), HttpStatus.NOT_FOUND);
    }
    todoMapper.updateTodo(requestModel);

    } else {
    todoMapper.createTodo(requestModel);
    }
    return new ResponseEntity<>(new Message("Success"), HttpStatus.OK);
  }
  /**
   * Update
   *
   * @param id Integer
   * @return
   */
  public ResponseEntity<?> delete(Integer id) {

    // データ取得
    Todo todo = todoMapper.selectTodo(id);

    if (todo == null) {
      return new ResponseEntity<>(new Message("No data found"), HttpStatus.NOT_FOUND);
    }
    todoMapper.deleteTodo(id);
    return new ResponseEntity<>(new Message("Success"), HttpStatus.OK);
  }
}
