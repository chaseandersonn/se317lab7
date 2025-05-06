package test.java.test;

import main.java.lab7main.CalculatorController;
import main.java.lab7main.CalculatorModel;
import main.java.lab7main.CalculatorView;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.timing.Pause;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUITest extends JFrame {

	private FrameFixture window;
	private final JTextField screen;

    @BeforeClass
	public static void setUpOnce() {
		FailOnThreadViolationRepaintManager.install();
	}

	@Before
	public void setUp() {
		CalculatorView view = GuiActionRunner.execute(CalculatorView::new);
		CalculatorModel model = new CalculatorModel();
		new CalculatorController(model, view);
		window = new FrameFixture(view);
		window.show();
	}
	public CalculatorGUITest() {
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setLayout(new BorderLayout());
		screen = new JTextField();
		screen.setEditable(false);
		screen.setName("screen");
		add(screen, BorderLayout.NORTH);
	}
	@Test
	public void testAddition() throws InterruptedException {
		window.button("btn_1").click();
		window.button("btn_2").click();
		window.button("btn_+").click();
		window.button("btn_3").click();
		window.button("btn_=").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("15.0");
		window.textBox("screen").requireText("15");

	}
	@Test
	public void testSubtraction() throws InterruptedException {
		window.button("btn_5").click();
		window.button("btn_0").click();
		window.button("btn_-").click();
		window.button("btn_2").click();
		window.button("btn_5").click();
		window.button("btn_=").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("25.0");
		window.textBox("screen").requireText("25.0");
	}
	@Test
	public void testMultiply() throws InterruptedException {
		window.button("btn_4").click();
		window.button("btn_*").click();
		window.button("btn_5").click();
		window.button("btn_=").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("20.0");
		window.textBox("screen").requireText("20.0");
	}
	@Test
	public void testDivide() throws InterruptedException {
		window.button("btn_8").click();
		window.button("btn_/").click();
		window.button("btn_2").click();
		window.button("btn_=").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("4.0");
		window.textBox("screen").requireText("4.0");
	}
	@Test
	public void testSquared() throws InterruptedException {
		window.button("btn_8").click();
		window.button("btn_sqr").click();
//		Thread.sleep(2300);
	}
	@Test
	public void testSquareRoot() throws InterruptedException {
		window.button("btn_3").click();
		window.button("btn_6").click();
		window.button("btn_sqrt").click();
//		Thread.sleep(2300);

//		window.textBox().requireText("6.0");
		window.textBox("screen").requireText("6.0");
	}
	@Test
	public void testMPlus() throws InterruptedException {
		window.button("btn_2").click();
		window.button("btn_+").click();
		window.button("btn_3").click();
		window.button("btn_=").click();
//		Thread.sleep(1000);
		window.button("btn_C").click();
		window.button("btn_5").click();
		window.button("btn_M+").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("10.0");
		window.textBox("screen").requireText("10.0");
	}
	@Test
	public void testMPlus_invalidInput() throws InterruptedException {
		window.button("btn_3").click();
		window.button("btn_2").click();
		window.button("btn_3").click();
		window.button("btn_2").click(); // 3232
		Thread.sleep(300);
		window.button("btn_M+").click(); // Try M+ without "="/		Thread.sleep(500);
//		window.textBox().requireText("Error");
		window.textBox("screen").requireText("Error");
	}

	@Test
	public void testMMinus() throws InterruptedException {

		window.button("btn_8").click();
		window.button("btn_+").click();
		window.button("btn_8").click();
		window.button("btn_=").click(); // 16
		window.button("btn_C").click();
		//execute next functions
		window.button("btn_3").click();
		window.button("btn_M-").click(); //13
		Thread.sleep(2300);
//		window.textBox().requireText("13.0");
		window.textBox("screen").requireText("13.0");
	}
	@Test
	public void testMRecall() throws InterruptedException {
		window.button("btn_4").click();
		window.button("btn_*").click();
		window.button("btn_2").click();
		window.button("btn_=").click(); // 8
		window.button("btn_C").click();
		window.button("btn_MR").click(); // Should recall 8
//		Thread.sleep(2300);
//		window.textBox().requireText("8.0");
		window.textBox("screen").requireText("8.0");
	}
	@Test
	public void testMClear() throws InterruptedException {
		window.button("btn_6").click();
		window.button("btn_*").click();
		window.button("btn_5").click();
		window.button("btn_=").click();//stores 30
		window.button("btn_MC").click(); // Clear memory
		window.button("btn_MR").click();
//		Thread.sleep(2300);
//		window.textBox().requireText("0.0");
		window.textBox("screen").requireText("0.0");
	}
	@Test
	public void testDelete() throws InterruptedException {
		window.button("btn_1").click();
		window.button("btn_2").click();
		window.button("btn_3").click();
		window.button("btn_.").click();
		window.button("btn_4").click();
		window.button("btn_Del").click();
		window.button("btn_Del").click();
		window.button("btn_Del").click();
		Thread.sleep(2300);
//		window.textBox().requireText("12.0");
		window.textBox("screen").requireText("12.0");
	}
	@Test
	public void testClear() throws InterruptedException {
		window.button("btn_5").click();
		window.button("btn_0").click();
		window.button("btn_C").click();
//		Thread.sleep(2300);
		window.textBox("screen").requireText("");
	}


	@After
	public void tearDown() {

		if(window != null) {
			window.cleanUp();
		}

	}
	public JTextField getScreen(){
		return screen;
	}
}
