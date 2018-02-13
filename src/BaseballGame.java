import java.util.Scanner;

public class BaseballGame {
	
	public static int[] comNumber;
	public static int[] userNumber;
	
	public static int[] ranNumList() {
		int tmp,random;
		comNumber = new int[] {1,2,3,4,5,6,7,8,9};
		for(int i=0; i<comNumber.length; i++) {
			random = (int)(Math.random()*comNumber.length);
			random = Math.min(random,comNumber.length-1); // 인덱스 숫자 필요
			// swap
			tmp = comNumber[i];
			comNumber[i] = comNumber[random];
			comNumber[random] = tmp;
		}
		return comNumber;
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
		if(comNumber[0]==userNumber[1] || comNumber[0] == userNumber[2]) ball++;
		if(comNumber[1]==userNumber[0] || comNumber[1] == userNumber[2]) ball++;
		if(comNumber[2]==userNumber[0] || comNumber[2] == userNumber[1]) ball++;
		return ball;
	}3
	
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
