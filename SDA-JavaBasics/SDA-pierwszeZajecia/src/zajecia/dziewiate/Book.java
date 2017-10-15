package zajecia.dziewiate;

/**
 * Created by RENT on 2017-02-11.
 */
public class Book {
    private String title;
    private Author author;
    private int numberOfPages;
    private int releaseDate;
    private String description;
    private String[] content;
    private String category;

//    konstruktory:
    public Book(String title, Author author, int releaseDate, String[] content) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.content = content;
//      this przy numberOfPages nie jest tutaj niezbedne, ale jest bardziej czytelne
        this.numberOfPages = content.length;
    }

    public Book(String title, Author author, int releaseDate, String description, String[] content, String category) {
        this(title, author, releaseDate, content);
        this.description = description;
        this.category = category;
    }

//  gettery i settery:
    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public String[] getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//  możliwe metody:
    public String getPage(int index) {
        int actualIndex = index -1;
        if(actualIndex >= 0 && actualIndex < this.numberOfPages) {
            return content[actualIndex];
        } else {
            return "There is no such page";
        }
//      return (actualIndex >= 0 && actualIndex < this.numberOfPages) ? content[actualIndex] : "There is no such page";
    }

//    alt+insert -> toString
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    //    poza zajeciami, moje
    public void printInfoAboutBook() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Title: ")
                .append(title)
                .append(". Author: ")
                .append(author)
                .append(". Category:: ")
                .append(category);
        String toPrint = sb.toString();
        System.out.println(toPrint);
    }
}
