package puzzle15;

/**
 * @author Abdalla Sobehy, Fred Aklamanu, Mohsin Kazmi, Renaud
 * @version 1
 * <tt> Fitness </tt> is a fitness function to evaluate how close we are to the solved board.<br>
 * Input: valid board input which is randomly shuffle.
 * return: value b/w 0 and 1. ( 0 means solved state & 1 means most mixed up state of the board )
 * Tested by {@link TestBoard}
 */
public class Fitness {

	private float most_mixed_up = 1;
	
	/*
	 * fitness_function_1 considers:
	 * 	1) tile current position (means give weightage to each tile place) and 
	 *  2) distance in terms of steps from the tile original position.
	 * 
	 * Algorithm gives 50% weightage to 1) and 50% weightage to 2) for calculating
	 * fitness value of given board and at the end, both values are added up to return.
	 * 
	 */
	public float fitness_function_1(Board board) {
		float ret1 = 0, ret2 = 0;

		ret1 = tiles_in_position(board);
		ret2 = displace_tiles_steps(board); 
	
		return (float) (0.5 * ret1 + 0.5 * ret2);
	}	
	
	/*
	 * fitness_function_2 considers:
	 * 	The number of misplaced tiles
	 * if the board is in the solved state, this function return 0
	 * if all the tile are misplaced, this function return 1
	 * 
	 * @param board Board where is applied fitness function
	 * @ return float ratio between the number of misplaced tiled,and the total number of tile
	 */
	
	public float fitness_function_2(Board board) {
		return tiles_in_position(board);
	}
	
	public float fitness_function_3(Board board) {
		
		
		// Implement Fitness Function 3 here
		
		return most_mixed_up;
	}
	
	private float tiles_in_position(Board board) {
		float tiles_in_position = 0;
		float ret = 0; 
		int [] index;
		int [] temp_index;
		Board solved = new Board();
		for(int i=0;i<17;i++){
			if (i == 1)
				continue;
			index = board.get_position(i-1);
			temp_index = solved.get_position(i-1);
			if (index[0] == temp_index[0] && index[1] == temp_index[1])
			{
				tiles_in_position += 1;
			} 
		}
		ret = (float)(most_mixed_up - tiles_in_position/16.0);
		return ret;
	}

	private float displace_tiles_steps(Board board) {
		float total_tile_steps = 0;
		float ret = 0; 
		int [] index;
		int [] temp_index;
		Board solved = new Board();
		for(int i=0;i<17;i++){
			if (i == 1)
				continue;
			index = board.get_position(i-1);
			temp_index = solved.get_position(i-1);
			if (!(index[0] == temp_index[0] && index[1] == temp_index[1]))
			{
				if (index[0] < temp_index[0])	
					total_tile_steps +=  temp_index[0] - index[0];
				else
					total_tile_steps += index[0] - temp_index[0];
		
				if (index[1] < temp_index[1])
					total_tile_steps +=  temp_index[1] - index[1];
				else
					total_tile_steps += index[1] - temp_index[1];
			}
		}
		
		/* In most mixed up board, by keeping maximization of tile steps
		 * from its original position. 
		 * |12 |15 | 9 |13 |
		 * |11 |   |10 |14 |
		 * | 8 | 3 | 2 | 5 |
		 * | 4 | 7 | 6 | 1 |
		 * 
		 * In this case, we require 60 single tile moves
		 */
		//System.out.println("total steps required: " + total_tile_steps);
		ret = (float) (total_tile_steps/60.0);
		return ret;
	}
}