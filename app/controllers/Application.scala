package controllers

import play.api._
import play.api.mvc._
import it.innove.play.pdf.PdfGenerator

object Application extends Controller {

  private def host(implicit request: RequestHeader): String = {
    s"http://${request.host}/"
  }

  /**
   * This action has been used to render home page of the application
   *
   * @return
   */
  def index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index("Play!ng PDF"))
  }

  /**
   * This action has been used to generate example 1 pdf from the letter template
   *
   * @return
   */
  def letter: Action[AnyContent] = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.letter("Play!ng PDF"), host)).as("application/pdf")
  }

  /**
   * This action has been used to generate example 1 pdf from the newsletter template
   *
   * @return
   */
  def newsletter: Action[AnyContent] = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.newsletter("Play!ng PDF"), host)).as("application/pdf")
  }

}