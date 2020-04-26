public class Movie {
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  public static final int CHILDREN = 2;

  private String _title;
  private int _priceCode;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public String getTitle() {
    return _title;
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int arg) {
    switch(arg) {
      case REGULAR:
        _price = new RegularPrice();
        break;
      case CHILDREN:
        _price = new ChildrenPrice();
        break;
      case NEW_RELEASE:
        _price = new NewReasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrrect Price Code");
    }
  }

  public double getCharge(int daysRented) {
    return _price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }
}