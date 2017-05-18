public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        int score = 0, index = 0;
		int len = bowlingCode.length();
		int[] temp_scores = new int[len];
		
		for (int i = 0; i < len; i++) {
			Character temp = bowlingCode.charAt(i);
			if(temp.equals('X')){
				temp_scores[i] = 10;
			}
			else if(temp.equals('/')){
				temp_scores[i] = 10-temp_scores[i-1];
			}
			else if(Character.isDigit(temp)){
				temp_scores[i] = Integer.parseInt(temp.toString());
			}
			else if(temp.equals('|')){
				temp_scores[i] = -1;
				if(i+1 < len){
					temp = bowlingCode.charAt(i+1);
					if(temp.equals('|')){
						index = i;
					}
				}
			}
		}
		for (int i = 0; i < index; i++) {
			Character temp = bowlingCode.charAt(i);
			if(temp.equals('X')){
				int k = 2;
				for (int j = i+1; j <= i+k; j++) {
					temp = bowlingCode.charAt(j);
					if(temp.equals('|')){
						k += 1;
						continue;
					}
					temp_scores[i] += temp_scores[j];
				}
				score += temp_scores[i];
			}
			else if(temp.equals('/')){
				int k = 1;
				for (int j = i+1; j <= i+k; j++) {
					temp = bowlingCode.charAt(j);
					if(temp.equals('|')){
						k += 1;
						continue;
					}
					temp_scores[i] += temp_scores[j];
				}
				score += temp_scores[i];
			}
			else if(Character.isDigit(temp)){
				score += temp_scores[i];
			}
			else if(temp.equals('|')){
				temp = bowlingCode.charAt(i+1);
				if(temp.equals('|')){
					break;
				}else{
					continue;
				}
			}
		}
		return score;
    }
}
