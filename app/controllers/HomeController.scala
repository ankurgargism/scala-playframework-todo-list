package controllers

import javax.inject._
import models.Task
import play.api._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents)
  extends AbstractController(cc)
  with play.api.i18n.I18nSupport {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Redirect(routes.HomeController.tasks())
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def tasks = Action { implicit request =>
    Ok(views.html.tasks(Task.all(), taskForm))
  }

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.HomeController.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.HomeController.tasks)
  }

  def updateTask(id: Long) = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks(Task.all(), errors)),
      label => {
        Task.update(id, label)
        Redirect(routes.HomeController.tasks)
      }
    )
  }
}
