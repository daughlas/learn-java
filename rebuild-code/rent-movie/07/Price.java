abstract class Price {
  abstract int getPriceCode();
  abstract double getCharge();
  int getFrequentRenterPoints(int daysRented) {
    return 1;
  };
}

class RegularPrice extends Price {
  int getPriceCode() {
    return Movie.REGULAR;
  }
  
  double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }
    return result;
  }
}

class ChildrenPrice extends Price {
  int getPriceCode() {
    return Movie.CHILDREN;
  }

  double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }
}

class NewReasePrice extends Price {
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  double getCharge(int daysRented) {
    return daysRented * 3;
  }

  int getFrequentRenterPoints(int daysRented) {
    if (daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }
}
