package algorithm;

import org.junit.runner.JUnitCore;

import exceptions.TriangleException;
import interfaces.Calculator;

/**
 * Created by joaopaulo on 29/01/17.
 */
public class TriangleCalcImpl implements Calculator{

    /**
	 * Esse método calcula o melhor percurso (maior soma) iniciando da base do triangulo, primeiro ele valida
	 * o triângulo passado e então calcula o maior valor entre as linhas do triangulo, retornando o maior valor ao final
	 *
	 * @param array multidimensional (triângulo)
	 * @return soma do melhor percurso Integer.
	 */
    public int calculate(final int[][] triangle) {
        parseTriangle(triangle);//verifica se o array multidimensional é um triangulo válido

        // inicializa o array em que será preenchido os valores máximos
        int[] currentRow = new int[triangle.length + 1];

        // inicializa o array que será atualizado com array 'currentRow' sempre que 'currentRow' estiver finalizado
        int[] previousRow = new int[currentRow.length ];

        //Iteração sobre o triângulo
        for (int row = triangle.length - 1; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                currentRow[col] = Math.max(previousRow[col], previousRow[col + 1]) + triangle[row][col];
            }
            int[] tmp = previousRow;
            previousRow = currentRow;// a linha já calculada é repassada ao array 'previousRow'
            currentRow = tmp;
        }

        // o valor da soma final é calculado na linha inicial do array 'previousRow'
        return previousRow[0];
    }

    private int[][] parseTriangle(final int[][] mArray) throws TriangleException {
        if (mArray == null || mArray.length == 0) {
			throw new TriangleException("No values were found to analyze the triangle.");
		}
        for (int pos = 0; pos < mArray.length; pos++) {
			if (mArray[pos].length != (pos + 1)) {
				throw new TriangleException(String.format("Row %d expected %d columns!", pos, pos + 1));
			}
		}
        return mArray.clone();
    }

	public static void main(String[] args) throws Exception {
		JUnitCore.main(
			"br.com.fiumari.hell-triangle.src.test.java.algorithmTests.CalculateTriangleImplTest");
	}


}
