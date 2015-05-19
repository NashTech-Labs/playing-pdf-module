package controllers

import play.api._
import play.api.mvc._
import it.innove.play.pdf.PdfGenerator

object Application extends Controller {

  private def host(implicit request: RequestHeader): String = {
    s"http://${request.host}/"
  }

  def index = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.letter("Your new application is ready."), host)).as("application/pdf")
  }

  def letter = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.letter("Your new application is ready."), host)).as("application/pdf")
  }

  def newsletter = Action { implicit request =>
    Ok(PdfGenerator.toBytes(views.html.newsletter("Your new application is ready."), host)).as("application/pdf")
  }

}