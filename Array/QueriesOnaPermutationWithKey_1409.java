package Array;
/*
1409. Queries on a Permutation With Key
 */
public class QueriesOnaPermutationWithKey_1409 {
    public static void main(String[] args) {
        QueriesOnaPermutationWithKey_1409 obj= new QueriesOnaPermutationWithKey_1409();

        int queries[]= {3,1,2,1};
        int m=5;
        obj.processQueries(queries,m);
    }
    public int[] processQueries(int[] queries, int m) {

        int[] ans= new int[queries.length];
        int[] p= new int[m];
        for(int i=0;i<m;i++){
            p[i]=i+1;
        }
        int i=0;
        for(int q:queries){
            int index= findIndex(p,q);
            ans[i]=index;
            i++;

            p=flip(p,index);
        }
        return ans;
    }

    public int findIndex(int[] p, int num){
        int idx=-1;
        for(int i=0;i<p.length;i++){
            if(p[i]==num){
                idx=i;
                break;
            }
        }
        return idx;
    }

    public int[] flip(int[] nums , int j){
        int temp=nums[j];
        for(int i=j-1;i>=0;i-- ){
            nums[i+1]=nums[i];
        }
        nums[0]=temp;
        return nums;
    }
}
