package example.newspapercrud.domain.error;

public class DatabaseError extends RuntimeException {
    public DatabaseError(String message) {super(message);}
}