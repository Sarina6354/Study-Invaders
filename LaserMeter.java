public class LaserMeter{
  private int currentX;
  private int y;
  private int laserCount;

  public LaserMeter{
    currentX = 100;
    y = 95;
    drawMeter();
    laserCount = 5;
  }

  private void drawMeter(){
    StdDraw.setPenColor(StdIn.WHITE);
    for(int i = 0; i < 5; i++){
      StdDraw.circle(currentX, y, 2);
      currentX = currentX - 4;
    }
  }

  public void addShots(){
    StdDraw.setPenColor(StdIn.WHITE);
    for(int i = 0; i < 5; i++){
      StdDraw.circle(currentX, y, 2);
      currentX = currentX - 4;
      laserCount++;
    }
  }

  public void useShots(){
    StdDraw.setPenColor(StdIn.BLACK);
    StdDraw.circle(currentX, y, 2);
    currentX = currentX + 4;
    laserCount--;
  }
}