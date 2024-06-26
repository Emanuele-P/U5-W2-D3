package ep2024.u5w2d3.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Element with id " + id + " not found :(");
    }
}
