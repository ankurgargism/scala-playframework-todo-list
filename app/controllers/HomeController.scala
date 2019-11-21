package controllers

import javax.inject._
import models.Task
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page. Each method in this controller maps to a route. See conf/routes file
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
   * a path of `/`. Here we are simply sending a redirect response 303 to tell the client to redirect to /tasks
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
        /**
          * TODO: [TASK-2]
          * 1.Use the model class to call the create method
          * 2. Remove the Ok response below and send the redirect(refer to index method) response to go to /tasks page
          */
        Ok
      }
    )
  }

  /**
    * TODO: [TASK-5] You need to implement the method to do the following
    * 1. Use the form binding to get the form data
    * 2. In the success function, call the update method of the model class to update the given task with id
    * 3. Redirect the user to /tasks
    * @param id
    * @return
    */
  def updateTask(id: Long) = TODO

}
