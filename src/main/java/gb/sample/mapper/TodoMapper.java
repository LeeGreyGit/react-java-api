package gb.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import gb.sample.model.TodoUpdateRequestModel;
import gb.sample.model.Todo;

@Mapper
public interface TodoMapper {
  List<Todo> getTodoList();


  /**
   * Select todo
   *
   * @param id Integer
   * @return Todo
   */
  Todo selectTodo(@Param("id") Integer id);

  /**
   * Create todo
   *
   * @param request TodoUpdateRequestModel
   * @return Integer
   */
  Integer createTodo(@Param("request") TodoUpdateRequestModel request);

  /**
   * Update todo
   *
   * @param request TodoUpdateRequestModel
   * @return Integer
   */
  Integer updateTodo(@Param("request") TodoUpdateRequestModel request);

  /**
   * Delete todo
   *
   * @param id Integer
   * @return Integer
   */
  Integer deleteTodo(@Param("id") Integer id);

}
