import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	
	public static int[] ranNumList(int[] number) {
		int tmp,random;
		for(int i=0; i<number.length; i++) {
			random = (int)(Math.random()*number.length);
			random = Math.min(random,number.length-1); // 인덱스 숫자 필요
			// swap
			tmp = number[i];
			number[i] = number[random];
			number[random] = tmp;
		}
		return number;
	}
	
	
	public static int[] userInput(int[] number) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요 ex)123 : ");
		int userNum = scan.nextInt();
		for(int i = 2; i >= 0; i--) {
			number[i] = userNum%10;
			userNum = userNum/10;
		}
		return number;
	}
		
	public static int countStrike(int[] comNumber, int[] userNumber) {
		int strike = 0;
		for(int i=0; i<userNumber.length; i++) {
			if (comNumber[i]==userNumber[i]) strike++;
		}
		return strike;
	}
	
	public static int countBall(int[] comNumber, int[] userNumber) {
		int ball = 0;
		for(int i=0;i<3;i++) {
            ball += countBall2(i,comNumber,userNumber);
        }
		return ball;
	}
	
	private static int countBall2(int b, int[] comNumber, int[] userNumber) {
		int ball = 0;
		for(int j=0;j<3;j++) {
            if (b!=j && comNumber[b] == userNumber[j]) ball++;
        }
		return ball;
	}
	
	public static void display(int strike, int ball) {
		
		if (strike > 0 || ball > 0) { 
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
		}
		
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}
	}
	
	public static void playGame() {
		int[] comNumber = new int[]{1,2,3,4,5,6,7,8,9};
		int[] userNumber = new int[3];
		ranNumList(comNumber);
		while(true) {
			int s,b;
			userInput(userNumber);
			s = countStrike(comNumber,userNumber);
			if(s==3) {
				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
				break;
			}
			b = countBall(comNumber, userNumber);
			display(s,b);
			
		}
	}

	public static void main(String[] args) {
		playGame();	
	}

}