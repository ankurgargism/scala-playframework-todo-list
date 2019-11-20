package models

case class Task(id: Long, label: String)

object Task {

  val tasks = collection.mutable.Map[Long, String]()

  def all(): List[Task] = Nil

  def create(label: String) {}

  def delete(id: Long) {}

  def update(id: Long, label: String) {}

}
