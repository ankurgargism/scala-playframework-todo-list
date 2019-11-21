package models

/**
  * LBCD-NOTE: Simple POJO to model immutable data. https://docs.scala-lang.org/tour/case-classes.html
  * @param id
  * @param label
  */
case class Task(id: Long, label: String)

/**
  * LBCD-NOTE:  Companion singleton object that holds static variables and methods
  * https://docs.scala-lang.org/tour/singleton-objects.html
  */
object Task {

  /**
    * Static collection to act as in-memory DB. Feel free to override this to use any data structure you like
    */
  val tasks = collection.mutable.Map[Long, String]()

  /**
    * Method to return the list of tasks that the user has added till now.
    * @return
    */
  def all(): List[Task] = {
    Task(1, "Hardcoded task 1") :: Task(2, "Hardcoded task 2") :: Nil
    //TODO [TASK-1] Please complete business logic to return all the task from 'tasks' and remove the hard coding.
  }

  /**
    * Method to create a task and add it to the existing tasks
    * LBCD-NOTE: Unit is equivalent to java void.
    * @param label
    */
  def create(label: String): Unit = {
    //TODO [TASK-3] Please complete business logic to create a new task and add it to the existing tasks.
    // While creating a task each should have a unique id to it.
  }

  /**
    * Method to update a label of task with given id
    * @param id
    * @param label
    */
  def update(id: Long, label: String): Unit = {
    //TODO [TASK-6] Please complete business logic to update a given task
  }

}
