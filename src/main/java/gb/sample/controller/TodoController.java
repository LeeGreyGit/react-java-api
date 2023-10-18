package gb.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gb.sample.model.TodoUpdateRequestModel;
import gb.sample.model.Todo;
import gb.sample.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoService todoService;


   /**
   * Todo list
   *
   * @return ResponseEntity<List<Todo>>
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseEntity<List<Todo>> list() {
    return ResponseEntity.ok(todoService.list());
  }

  /**
   * Update
   *
   * @param requestModel TodoUpdateRequestModel
   * @return
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public ResponseEntity<?> update(
      @RequestBody TodoUpdateRequestModel requestModel ) {
    return todoService.update(requestModel);
  }

  /**
   * Delete
   *
   * @param id Integer
   * @return
   */
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
  public ResponseEntity<?> delete(
          @PathVariable Integer id) {
    return todoService.delete(id);
  }
}
