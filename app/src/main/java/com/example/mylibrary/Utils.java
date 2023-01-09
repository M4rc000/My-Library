package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> WantToReadBooks;
    private static ArrayList<Book> favoriteBooks;

    public Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }

        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();

        } if (null == WantToReadBooks) {
            WantToReadBooks = new ArrayList<>();
        }

    }


    public void initData() {
        // TODO: add initial data
        allBooks.add(new Book(1, "Romeo and Juliet", "William Shakespeare", 150, "https://i.pinimg.com/originals/c8/7b/0f/c87b0f154ab3b6bf4ef875b97ba392e7.jpg", "A Book about romance love", "Long Description"));
        allBooks.add(new Book(2, "Harry Potter dan Orde Phoenix", "J. K. Rowling", 150, "https://media.harrypotterfanzone.com/order-of-the-phoenix-us-childrens-edition.jpg", "A Book about magic,life", "Long Description"));
        allBooks.add(new Book(3, "The Proposal", "Jasmine Guillory", 150, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6WUoJWMwr3-WNObWD_Dwiliv6UVEwToKQuBKFKDsle2xkt6JK", "A Book about romance,love,life", "Long Description"));
        allBooks.add(new Book(4, "Pride and Prejudice", "Jane Austen", 150, "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAKIAYAMBIgACEQEDEQH/xAAcAAACAgMBAQAAAAAAAAAAAAAEBQMGAAECBwj/xAA9EAACAQMDAQcCAwUGBgMAAAABAgMABBEFEiExBhMiQVFhcRQyI4GRFTOhsdEHUmKSwfBDcnOisuEWRIP/xAAaAQEAAwEBAQAAAAAAAAAAAAACAQMEAAUG/8QAJREAAgEDBAEFAQEAAAAAAAAAAAECAxEhEjFBURMEBRQiQjJS/9oADAMBAAIRAxEAPwDyOxt8tuYfrVisLUSeIIMY5qK2sZHQrEv5gU/0vTZY4s7T05461jq1DRTgL9NhEV5cAjlkxTnUdJ+hkhZmXLccDNCpbsJ5mCnfxwfKi72e4unQyv4gehFU68icQdrWJ07skbnk5JFM9Ot7XaInUhk4Yn+dAMHjK8gkHIPvTSyuj3UpkVTISfKi6jOUELLyICUnGUBqmXZSeeVjwTIT/Grzdljk/FVr9jrLqcsXeLhSTzxjzFWU58s5w4QjxnaVXw49PPzrUtqzMc8jrVoTs1NDlSQ5Cbht5yOM4qu30xtbkI2QobDeoFXwqangEoOO4Rc9mnWwWeOOcv3W9m3IV3YyVAHiBH86rjIc9P0q7SXWky20cdtLexKm4gfTiQpk8lWLjyGenWqpMqtJIULFc5yw2kj1Ipwcv0CSXBdtP1CCKYIVCj+96Ud+1AEYQzqzdFSMdPmklvb5PfOR3h+0kcVPMsb7pp5AiqCRsbmss4q5qg2kTw6neCYpkyMz4ZCgyPg+Yp+9us4yrgMeBn29KrkM7PJbpwFAByMZPHn71drax+q054h4Zdp2NjqaqqWQoq5XHVVYqc9a3FJ4n8RxxUSrKyhpPuH3D3rArKxJ6dcVAbEtxKWDjPNSWejx6xfKCxRimWIOOnShplJRj68020K/isGkmnDEmPCY8667SwSt8h+kaX9LL3d02XiyFIbqDVc1zsnEN08pwsjAgnqp8xV1hcXjiXG3IDKM1LIVwBIoIBzg+tVxnKLuXyimilXvZBbayR7NWZyvi5wF46153eDuZ5AR0bHtXuRuRK5RecjkVTbzsGLm9nluJ+5tS2VEeNxHpzwK00KufsZ60FbBX+9EkAdZNpHVM8n3oSTuRkuzqeuUfpQq3cgARioRDkADrRYD3294I3ZE8T5AwAf9mr2rFcXfCGOjRxiMyGE5+5XPUY9Pmr3Bqg0+y3zELIR4OnJ9Ko+jrLJdxrKfAMbUHQCvSrW0s7iRDOoJX7TnpWOs1fJoinpKzepmZp2XYk6iVRj16/xzUWEaXbgDK4q09qL2wht3tZ4S8mN0QjXlT659PaqikjGQMo8uc0Y5VwPBxfjwERggYxXSQSd2oKk+QNczzHEgx1INOfrLU220J4uo59qlto4F02WZZtuCGRchtx6emKZDVbN75bOeYLK44w2Bn0/OqprV5NNaMNObDxALI4bB5PFCdjtLm17UZ0uyZreFD+IMBjJkYAI9s1Z4vrqkR5H/ACemwQwwA93H4j19/wA64vkkMBHAZvToBRFnZywwqjbm7sAd5Jgk/wDugNbuti/Twh5Jm6IvX5NVJ5IaPDXYNI4xVh7KztHHdQuPwpsKXHVTgj9KSyWxQ+e7PSrXoFo30kfUKMZGPOtteS0hoReq4+sLa3RYlXaSByw6nmnhbndHhfYeVK2h7kKyjHFa+rMZJY4x6msG5swN9WvHbSnXKgbCHO3J9vj5qtllZIkxtI4Zh1NEza1sjeKJMmRSp8xg0NtTbEcEndilFWKJg1y4MhDgLkY8NA3l8kFs7I32ry3p7CmN/Cn08kuCHV+mfKkWqW/f3AhTIt1O9vf2q6nFN5AKbf6iZlMcbSXNywSGNepBPQfJr3fst2dtdE0+G2jQd6BmRyfPz5rzH+zm2W+7bI5UGOzgeUZHAPCj+deyiaPkbgcHyqa8sqIUC6jFmylVZNnH3Dy5qh9q7sadYnuSPG2xSee8Pmx9RVi1nXoGkezg/FI4dgeAc9PmvMO1mqvqGplN34UHgUZ4z5/79qrpRcpCeEFaRZJet9mdvVjVqtrCOEKqgYFIdKuEgjVE4Ap7DfKepGT6+dOrFtnU5pIYvAhiy2DQVx2Z1C7he7gMJXZ4Yg3iI/TGfauvqw4YM20beOOtMbfV+5jjORhRhl9R6/NVqLQ3K5SJAI5SkissqHaQRjHrmmJlhaCIwxupj294xOQW5/Sj+0phnY3iFRIo+4c71Pr7j1quTONgZTnnnFOzBawdeSxPZMhU94z7t2fL4pHdsTDIQCcDxMB0HqannuDkEkYFV/Ubwi4ZAx2t/GrKcXcMpWLf/ZdGLfU7qYk7prZ8fAdR/WrtqV99NZTGHJkJAB+aq/Z19PsUsWNyUupYDGEK8HJz1/IUu7c9oO67vTNOYtcyHc7jqo8se/WhODnMiLSQXNe2NppVysF2BqCcdM4Pnj3rzy6lw5JOcnJNdX2LDZBv3S7cyEdAT5Clk0/eYAGMdT61rp00lgEp9n1QOxvZ5WBXSoBg5xz/AFqb/wCK6GTn9mw9egyB+madkVqN45c926vjrtbOK8zVLsm4oHZbRMAfs9OP8Tf1oCXStEOoxWdrpSTyZzNJ3rBIlHX5PTj3pzqOrW2n+F90kpYKEQZ8R6AnoPXny5pemj6hDN3tldQRb2EsoAOHfcSwz/dwcAe5OMnNJN9hbJpuymhTqFk06PaBgBSVAH5GoF7EdnFORpqZ/wCo/wDWpJLHXyLkJqsGJS2zMWDH0xtwOPP169TRs8Ny+l/TG5SO6ZdokDEZPz1zjzrry7OuxPf9kuyltEZrrTIto6AO2W+OaFs+wPZe8t0uLvs7DFI3PdvI7EDyzz1x5Ufe6NLd3fe9/aTXG1iUlLbVbHACA/b88n8q6tdJ1ezVhbXdnvYKN7xEnz3H368eXAGKnU+zrnM3ZnsvamES6PZM5bbEJIg5HxnOPU+lZL2Q7LSz98+k2DTf38eL+dcS6DeSzCb6mGVhMG72QlmePk7OmF55OOvTgcVPaabeRX0jS3FhLCW/ddwAUGBjGB88fHNG77OBX7A9k5JjM+g2bOeSSCc/lmop+wHZNo2T9gWQB81TB/WrXjjiuHXii6k+xpImxzXnlhJPYy3l7psCIY3mild4yEZmuMKM8ZIBPrivQs1XBpl8ez9xZmJe/e7aVV7wY2mXf1+KRCdhJdNLYQ6rZGKCW8l3pNcMD4lFuHY49eR84yae6LrhuNSGnbIxHGhQYJ35VIySfY78flQmr6LqNzeX1xbwxkyyNsVpQMq0AjJ/Iimeg2Nxp89yssKbJ3E3eb+VPdopXHypOa4l2sCXHaC7W7ubWBbR5Iri3jDeIqO9dlIPPVceXxQMusT6pPpcbxQoqTwSSEZzvYyL4fbwfxrLTQtUt5AGhjdVmt23iUZYRyu5OMdSGrdnoWpQTWcndRlVaEy/ijw7HkPHrkOv6V1yUonGoxFu1s720ObmGaCXve7yEQRPuyffgYzzRSdpbtY9M7+O1DXcUUzhd32yMqgLk9QWJPsPzpnHa3Calq8zRL3dzGgiO8clVI6eXWgbOyuNOXTLiaOEi309ba53PgR7dp3j1HDVFyMMH03XLiOK3gigtUizCNqqw++V0bHP+EH9aDttTe6vo9RuILcrcG0ZVwfCpaTaev3D9Kk0/S76WGzuYYlaJ+5Yln2lQkzv088hhXVnoGow/TwPDGY4TbpvEo8Sxs+Tj4YcVwvqFXHaW5t9NtLt4rcG6R50Ulv3SgHH/PyB/pVmB3IGHQjNV210u+t4tK3QQu2nq8AUy/ejAANnHH2rxVhJ45osOODFbNQz2wlcv3rrnH2+1E4rCPWtPx092BtgZtUCqBK4wSc561z9MmFzNJlT4efbFGFM1G0dT8SHYXUa4B+4UH9/Jx5FvauGhTJKzsuTnAbpXckPtURipL0UHyVv1ElwbEK9DcvjOfurHiiwB9QQQCM7+vzUZiqNoc0l7fDsD9XLonMUeMfVsM/4h/Cumjgbcr3fhOOO8GQaAkg9qElhx5U17dT7BL1s1wPolhRw/wBXuxnguMVqW8twcGePP/MKrbw5HShpIseVNe2w/wBB+dJfkveaygodTsZyRDeW7n0WRTRXeIDguoPuazpnoMkrMZqEXdselzCf/wBBXDalp6fdfWw5I/fL1/WmmBomKj0rgoKz6mA9Jojn0cVG93AP+NH/AJhTjKxW4mzGKjaMVG1/bgkd/Fn03iuRfQH/AIyf5hVqqR7KnTNyR0LJGPXFENd25476P/MKGkubcghpUx55YU1UXZVKm+jzLtd2pv7fU549PvY4raPG11jDg+vt6455xT/sfrg7R6SJ3TbcxeGcAcbv9Piqr/afNp1vPbw28XdwqvefhAbXbPJPOTjjr/rTP+yt5I7a7vL27txb3W3uI8qG4zzgDA4IGKmNRb3O8d47E9vFZKdy21uD6heTROLUniCEny4pIJ9nAbBHXyqYXW0qC3B9ua+dlSlfc9YbYhH/ANeP+FaZ4UXiGMfkDSz6tCCMsPnjisW8EUokjZQ69MkEioVF8haHAh3AFEtirDOd6jr881G0Um8Lst8kZH4ifzzS/wDbU7Nt75TsPO0Lz65OKLj122MIEkcxkxwwdeT/AJeOK0KjANmdLBKT4Y7bg4PjTg/Oa03erEWxDgAnBkTy/Oo5+0dtFtZrWUbSTnv0XI9/BSqPWL4vzIqqSSAFU4Hl5VZ4IWuQN47kGLMnJzg5GBUgmBGfDS2B2uN+/Bdjn0/lXbShOgHHqKyyhmyFoDnMUo/ECkHrXYMXof1JpYZggH27z1Ga5a4Ixz+dHxyJUUA2ADLISMkqOvxXUR5j/wCof/Kt1lbJCRDL+9b5x/21o/eR5b/6VqsqYbEMmCgrDkA5c9R8VFIB38vA4U49ularKlEAmqEiBMEjIP8A45/nW7NiZeST46ysqz8Ae41QkbiCR4fL864vOPqMcYdMe3iFZWVm5LX/ACiNj+JEPLC/6V0CTKc+S1lZS4Cj/9k=", "A Book about love life", "Long Description"));
        allBooks.add(new Book(5, "Outlander", "Diana Gabaldon", 150, "https://m.media-amazon.com/images/I/41YawkyLcwL._AC_SY780_.jpg", "A Book about loop flashback life", "Long Description"));
    }


    public static synchronized Utils getInstance() {
        if (null == instance) {
            instance = new Utils();
        }
        return instance;
    }
    public static ArrayList<Book> getWantToReadBooks() {
        return WantToReadBooks;
    }
    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b: allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }

        return null;
    }

    public boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead(Book book) {
        return WantToReadBooks.add(book);
    }
    public boolean addToCurrentlyReadingBooks(Book book) {
        return currentlyReadingBooks.add(book);
    }
    public boolean addToFavoritebooks(Book book) {
        return favoriteBooks.add(book);
    }

    // Remove method
    public boolean removeFromAlreadyRead(Book book) {

        return alreadyReadBooks.remove(book);
    }
    public boolean removeFromWantToRead(Book book) {

        return WantToReadBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book) {

        return currentlyReadingBooks.remove(book);

    }
    public boolean removeFromFavorites(Book book) {

        return favoriteBooks.remove(book);
    }


}
