public class MergeSort {
    public static void mergeSort(int[] arr) {
        int tamanhoArry = arr.length;
        if (tamanhoArry < 2) {
            return;
        }

        int indiceMedio = tamanhoArry / 2; 
        int[] left = new int[indiceMedio];
        int[] right = new int[tamanhoArry - indiceMedio];

        for (int i = 0; i < indiceMedio; i++) {
            left[i] = arr[i];
        }

        for (int i = indiceMedio; i < tamanhoArry; i++) {
            right[i - indiceMedio] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int tamanhoEsquerda = left.length;
        int tamanhoDireita = right.length;

        int i = 0, j = 0, z = 0;

        while (i<tamanhoEsquerda && j<tamanhoDireita) {
            if(left[i] <= right[j]){
                arr[z] = left[i];
                i++;
            }
            else{
                arr[z] = right[j];
                j++;
            }
            z++;
        }
        while (i<tamanhoEsquerda) {
            arr[z] = left[i];
            i++;
            z++;
        }

        while (j<tamanhoDireita) {
            arr[z] = right[j];
            z++;
            j++;
        }
    }
}
