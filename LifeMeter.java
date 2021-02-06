public class LifeMeter{
  private int currentX;
  private int y;
  private int laserCount;

  public LifeMeter{
    currentX = 100;
    y = 90;
    drawMeter();
    laserCount = 5;
  }

  private void drawMeter(){
    StdDraw.setPenColor(StdIn.RED);
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