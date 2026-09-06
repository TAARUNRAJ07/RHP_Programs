
public class AdditiveNumber {
    public boolean isAdditiveNumber(String a) {
        int n = a.length();
        for(int i=1;i<=n/2;i++){
            if(a.charAt(0)=='0' && i>1)break;
            for(int j=1;n-i-j>=Math.max(i,j);j++){
                if(a.charAt(i)=='0' && j>1)break;
                long f = Long.parseLong(a.substring(0,i));
                long s = Long.parseLong(a.substring(i,i+j));
                String b = a.substring(i+j,a.length());
                while(b.length()>0){
                    long t=f+s;
                    String tn = String.valueOf(f+s);
                    if(b.startsWith(tn)){
                        f=s;
                        s=t;
                        b=b.substring(tn.length(),b.length());
                    }
                    else {
                        break;
                    }
                }
                if(b.length()==0)
                return true;
                    
            }

        }
        return false;
    }
}
