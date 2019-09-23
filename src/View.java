import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class View {
	final int canvasCount = 10;
    int picInd = 0;
	final static int canvasWidth = 500;
    final static int canvasHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    Image orc_img = createImage("orc_forward_southeast.png");
    
    GraphicsContext gc;

	public View(Stage theStage) {
		theStage.setTitle("Orc");

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();
		
	}

	public int getImageWidth() {
		return imgWidth;
	}

	public int getImageHeight() {
		return imgHeight;
	}

	public int getHeight() {
		return canvasHeight;
	}

	public int getWidth() {
		return canvasWidth;
	}

	public void update(double x, double y, String dir) {
		orc_img = createImage(dir);
        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        gc.drawImage(orc_img, imgWidth*picInd, 0, imgWidth, imgHeight,
                            x, y, imgWidth, imgHeight);
        picInd = (picInd + 1) % canvasCount;
		
	}
	
    private Image createImage(String orc) {
        Image img = new Image("images/orc/" + orc);
        return img;   	
    }
	


}