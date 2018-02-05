import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
	
	public static int[] comNumber;
	public static int[] userNumber;
	
	public static int[] ranNumList() {
		comNumber = new int[3];
		for(int i=0; i<comNumber.length; i++) {
			comNumber[i] = randomFill();
			for(int j=0; j<i; j++) {
				if (comNumber[i] == comNumber[j]) {
					i--;
					break;
				}
			}
		}
		return comNumber;
	}
	
	
	public static int randomFill(){

	    Random rand = new Random();
	    int randomNum = rand.nextInt(10);
	    return randomNum;
	    }
	
	public static int[] userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요 ex)123 : ");
		int userNum = scan.nextInt();
		userNumber = new int[3];
		for(int i = 2; i >= 0; i--) {
			userNumber[i] = userNum%10;
			userNum = userNum/10;
		}
		return userNumber;
	}
	
	public static int countStrike() {
		int strike = 0;
		for(int i=0; i<3; i++) {
			if (comNumber[i]==userNumber[i]) strike++;
		}
		return strike;
	}
	
	public static int countBall() {
		int ball = 0;
		for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if (i!=j && comNumber[i]== userNumber[j]) ball++;
            }
        }
		return ball;
	}
	
	public static void display() {
		
		if (countStrike() > 0 || countBall() > 0) { 
            System.out.println(countStrike() + " 스트라이크 " + countBall() + " 볼");
		}
		
		if (countStrike() == 0 && countBall() == 0) {
			System.out.println("낫싱");
		}
	}
	
	public static void playGame() {
		ranNumList();
		while(true) {
			userInput();
			countStrike();
			if(countStrike()==3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
			countBall();
			display();
			
		}
	}

	public static void main(String[] args) {
		playGame();
	
	}

}
