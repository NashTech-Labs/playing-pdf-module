# ![alt tag](/public/images/logo.png)
Basic example for generating PDF documents dynamically from Play Application with the help of play2-pdf module

[Play 2.3.x PDF module](https://github.com/innoveit/play2-pdf): This module helps generating PDF documents dynamically from your Play! web application. It simply renders your HTML- and CSS-based templates to PDF. It is based on the Flying Saucer library, which in turn uses iText for PDF generation.

### Usage

You can use a standard Play! Scala template like this one:
``` html
@(message: String)

@main("Play!ng PDF") {
    Image: <img src="/public/images/favicon.png"/><br/>
    Hello world! <br/>
    @message <br/>
}
```
Check the below template list for more complex template design:
1. [Letter PDF](https://github.com/knoldus/playing-pdf-module/blob/master/app/views/letter.scala.html)
1. [News Letter PDF](https://github.com/knoldus/playing-pdf-module/blob/master/app/views/newsletter.scala.html) 

Then this template, after having imported ```it.innove.PdfGenerator```, can simply be rendered as:
``` scala
	def letter: Action[AnyContent] = Action { implicit request =>
    	Ok(PdfGenerator.toBytes(views.html.letter("Play!ng PDF"), host)).as("application/pdf")
  	}
```  

### Template rules

Templates must generate XHTML.

If the template is using an image, stylesheet, etc., it usually is loaded via an http call.
The PDF modules tries to optimize that resource loading:
If you specify the URI as a path into the classpath of your Play! app, the resource is loaded directly instead.
See the above sample template for an example.

Of course you can link to CSS files in your class path also, but be aware not to
use the ``` media="screen"```qualifier. 
  
Fonts you use must be explicitely packaged with your app.
``` html
<html>
	<head>
		<style type="text/css"><!--
		body {
			...
			font-family: FreeSans;
		}
		--></style>	
	</head>
	<body>
		...
	</body>
</html>
```
Since the FreeSans font is not available to the java VM, you are required to
add the corresponding font file, "FreeSans.ttf" to your Play! app.
You can add your fonts with ```PdfGenerator.loadLocalFonts``` method, for example if you put the font in the folder  ```/conf/fonts``` you load the font with:

```PdfGenerator.loadLocalFonts(new String[]{"fonts/FreeSans.ttf"})```

![alt tag](/public/images/gravatar.png)

- Used [Play2-PDF Module](https://github.com/innoveit/play2-pdf) to generate PDF from HTML template
- Embedded JS & CSS libraries with [WebJars](http://www.webjars.org/)
- Integrating with a CSS framework (Twitter Bootstrap 3.1.1)
- Bootswatch-Cerulean with Twitter Bootstrap 3.1.1 to improve the look and feel of the application

-----------------------------------------------------------------------
### Instructions
-----------------------------------------------------------------------
* To run the Play Framework, you need JDK 6 or later
* Install Typesafe Activator if you do not have it already. You can get it from [here](http://www.playframework.com/download) 
* Execute `./activator clean compile` to build the product
* Execute `./activator run` to execute the product
* playing-pdf-module should now be accessible at localhost:9000

-----------------------------------------------------------------------
### References
-----------------------------------------------------------------------
* [Play Framework](http://www.playframework.com/)
* [Play2-PDF Module](https://github.com/innoveit/play2-pdf)
* [Bootstrap 3.1.1](http://getbootstrap.com/css/)
* [Bootswatch](http://bootswatch.com/cerulean/)
* [WebJars](http://www.webjars.org/)
