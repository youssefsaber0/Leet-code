class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n=s.length();
        unordered_map<char, int> umap;
        int max_length=0;
        int current_max=0;
        cout<<n<<endl;
        int l=0;
        int r=0;
        for(int i=0;i<n;i++){
            if (umap.find(s.at(i)) == umap.end()){
               umap[s.at(i)]=i;
               r=i;
            }
            else{
                r=umap[s.at(i)];
                cout<<" r "<<r<<endl;
                while(l<=r){
                    umap.erase(s.at(l));
                    cout<<" Current max "<<r-l+1<< endl;
                    l++;
                }
                umap[s.at(i)]=i;   
                
            }
                           if((r-l+1)>max_length){
                   max_length= r-l+1;
                    
                }
        }
        cout<<" Current max00 "<<r<< endl;
        return max_length;
    }
};