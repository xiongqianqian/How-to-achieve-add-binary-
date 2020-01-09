class Solution {
  public String addBinary(String a, String b) {
        String strSum = "";
        int size = a.length() > b.length() ? a.length() : b.length();
        a=new StringBuffer(a).reverse().toString();
        b=new StringBuffer(b).reverse().toString();
        int[] aArr = new int[size];
        for (int i = 0; i < a.length(); i++) {
            aArr[i] = Integer.parseInt(a.substring(i, i + 1));
        }
        int[] bArr = new int[size];
        for (int i = 0; i < b.length(); i++) {
            bArr[i] = Integer.parseInt(b.substring(i, i + 1));
        }
        int[] re = new int[size + 1];
        int flow = 0;
        for (int i = 0; i <aArr.length; i++) {
            if (aArr[i] + bArr[i] + flow == 3) {
                re[i] = 1;
                flow = 1;
            } else if (aArr[i] + bArr[i] + flow == 2) {
                re[i] = 0;
                flow = 1;
            } else if (aArr[i] + bArr[i] + flow == 1) {
                re[i] = 1;
                flow = 0;
            } else if (aArr[i] + bArr[i] + flow == 0) {
                re[i] = 0;
                flow = 0;
            }
        }
        if (flow == 1) {
            re[size] = 1;
            boolean is=false;
            for (int i = re.length-1 ; i >= 0 ; i--) {
                if(re[i]!=0){
                    is=true;
                }
                if(is||i==0){
                    strSum = strSum + re[i];
                }

            }
        } else {
            boolean is=false;
            for (int i = re.length-2 ; i >= 0 ; i--) {
                if(re[i]!=0){
                    is=true;
                }
                if(is||i==0){
                    strSum = strSum + re[i];
                }

            }
        }
        return strSum;
    }
}
