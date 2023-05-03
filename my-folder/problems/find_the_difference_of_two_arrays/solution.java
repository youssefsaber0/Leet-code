class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    var set1 = new HashSet<Integer>();
    var set2 = new HashSet<Integer>();
    var common = new HashSet<Integer>();

    for (var n : nums1)
      set1.add(n);

    for (var n : nums2) {
      if (set1.contains(n)) {
        set1.remove(n);
        common.add(n);
      } else if (!common.contains(n)) {
        set2.add(n);
      }
    } 
    var ans = new ArrayList<List<Integer>>();
    ans.add(new ArrayList<>(set1));
    ans.add(new ArrayList<>(set2));

    return ans;
  }
}