# Object-Oriented Design Principles

### 1. SOLID

##### - S ( Single Responsibility Principle )
Всеки клас трябва да отговаря само за едно единствено нещо от приложението ( Всяка жаба да си знае гьола ). <br>

**Definition**<br>
*A class should have only one reason to change.*

```{java}
// Example: Objects that can print themselves.
// Bad
class Book {
 
    public String getTitle() {
        return this.title;
    }
 
    public String getAuthor() {
        return this.author;
    }
 
    public void turnPage() {
        // pointer to next page
    }
 
    public void printCurrentPage() {
        // prints current page
    }
}
```
```{java}
// Good
class Book {
 
    public String getTitle() {
        return this.title;
    }
 
    public String getAuthor() {
        return this.author;
    }
 
    public void turnPage() {
        // pointer to next page
    }
 
    public Page getCurrentPage() {
        return currentPage;
    }
}

interface Printer {
    void printPage(Page page);
}

class PanelPrinter implements Printer {

    public void printPage(Page page){
        // displays the page on the panel
    }
}
```

##### - O ( Open/closed Principle )
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

```{java}
class GraphicsDrawer {
    public void drawCircle(Circle c){
        //...
    }
    
    public void drawRectangle(Rectangle c){
        //...
    }
}
```

What happens if you want to draw a Triangle?
You should edit the GraphicDrawer class and add drawTriangle() method...
```{java}
class GraphicsDrawer {
    public void drawCircle(Circle c){
        //...
    }
    
    public void drawRectangle(Rectangle c){
        //...
    }
    
   +public void drawTriangle(Triangle c){
   +    //...
   +}
}
```
**This is bad. Classes should be closed for modification!**

*Instead...*
```{java}
class GraphicsDrawer {
    public void drawShape(Shape s){
        // draw the shape
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw(){
        // ...
    }
}

class Rectangle implements Shape {
    public void draw(){
        // ...
    }
}

class Triangle implements Shape {
    public void draw(){
        // ...
    }
}
```
