package example.newspapercrud.domain.error;

public final class FOREIGN_KEY_ERROR extends DataBaseError {
    public FOREIGN_KEY_ERROR() {
        super(Constantes.FOREIGN_KEY_ERROR);
    }
}