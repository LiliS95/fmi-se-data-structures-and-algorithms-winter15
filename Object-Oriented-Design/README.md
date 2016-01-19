# Object-Oriented Design Principles

### 1. SOLID

##### - S ( Single Responsibility Principle )
Всеки клас трябва да отговаря само за едно единствено нещо от приложението ( Всяка жаба да си знае гьола ). <br>

**Definition**<br>
*A class should have only one reason to change.*

```{java}
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
