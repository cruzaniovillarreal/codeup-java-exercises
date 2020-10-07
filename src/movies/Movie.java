package movies;

public class Movie {
    private String name;
    private String category;

    public Movie(String movieName, String movieCategory) {
        this.name = movieName;
        this.category = movieCategory;
    }

    public String nameGetter() {
        return this.name;
    }

    public String categoryGetter() {
        return this.category;
    }

    public void nameSetter(String newName) {
        this.name = newName;
    }

    public void categorySetter(String newCategory) {
        this.category = newCategory;
    }


}
