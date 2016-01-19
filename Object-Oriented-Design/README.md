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

##### - L ( Liskov substitution principle )
Likov's Substitution Principle states that if a program module is using a Base class, then the reference to the Base class can be replaced with a Derived class without affecting the functionality of the program module.

```{java}
// Good example:
class Vehicle {
    void startEngine() {
        // Default engine start functionality
    }
 
    void accelerate() {
        // Default acceleration functionality
    }
}

class Car extends Vehicle {
    void startEngine() {
        this.engageIgnition();
        super.startEngine();
    }
 
    private void engageIgnition() {
        // Ignition procedure
    }
}
```
##### - I ( The Interface Segregation Principle )
States that no client should be forced to depend on methods it does not use. ISP splits interfaces which are very large into smaller and more specific ones so that clients will only have to know about the methods that are of interest to them. 

*Example 1*
```{java}
// Bad 
interface Vehicle {
    void startEngine();
    void accelerate();
    void brake();
    void lightsOn();
    void lightsOff();
    void signalLeft();
    void signalRight();
    void changeGear();
    void startRadio();
    void stopRadio();
    void nextRadioStation();
}
```

```{java}
// Good 
interface ControllableEngine {
    void startEngine();
    void accelerate();
    void brake();
}

interface ControllableLights {
    void lightsOn();
    void lightsOff();
    void signalLeft();
    void signalRight();
}

interface ControllableAudio {
    void startRadio();
    void stopRadio();
    void nextRadioStation();
}
```

*Example 2*
```{java}
// meeeh
interface IWorker {
    public void work();
    public void eat();
}

class Worker implements IWorker{
    public void work() {
		      //.... working much more
    }

    public void eat() {
        //.... eating in launch break
    }
}

class Manager {
    IWorker worker;

    public void manage() {
        // doesn't care if you can eat
        worker.work();
    }
}
```


```{java}
// better
interface Workable {
    public void work();
}

interface Feedable{
    public void eat();
}

class Manager {
    Workable worker;

    public void manage() {
        worker.work();
    }
}
```

##### - D ( Dependency inversion principle )
*A. High-level modules should not depend on low-level modules. Both should depend on abstractions.<br>
B. Abstractions should not depend on details. Details should depend on abstractions.*

https://en.wikipedia.org/wiki/Dependency_inversion_principle

### 2. Program to interface, not implementation
### 3. DRY ( Don't repeat youself )
### 4. Encapsulate what varies
### 5. Depend on abstractions, not concrete classes
### 6. Favor composition over inheritance
### 7. KISS ( Keep it simple and sweet/stupid )
---
***Good Books***

- <a href="http://www.amazon.com/Head-First-Design-Patterns-Freeman/dp/0596007124">Head First Design Patterns</a> - good start
- <a href="http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612">Design Patterns: Elements of Reusable Object-Oriented Software</a> - more advanced

---
*Sources:*
- http://code.tutsplus.com/tutorials/solid-part-1-the-single-responsibility-principle--net-36074
- http://www.oodesign.com/open-close-principle.html
- http://code.tutsplus.com/tutorials/solid-part-3-liskov-substitution-interface-segregation-principles--net-36710
- https://en.wikipedia.org/wiki/Interface_segregation_principle
- http://code.tutsplus.com/tutorials/solid-part-3-liskov-substitution-interface-segregation-principles--net-36710
- http://www.oodesign.com/interface-segregation-principle.html
