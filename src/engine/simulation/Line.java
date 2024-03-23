package engine.simulation;

public class Line {

  private int Xdepart;
  private int Ydepart;

  public Line(int xdepart, int ydepart) {
    Xdepart = xdepart;
    Ydepart = ydepart;
  }

public int getXdepart() {
	return Xdepart;
}

public void setXdepart(int xdepart) {
	Xdepart = xdepart;
}

public int getYdepart() {
	return Ydepart;
}

public void setYdepart(int ydepart) {
	Ydepart = ydepart;
}

}