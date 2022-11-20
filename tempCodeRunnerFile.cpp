int findPeak(int v[], int start, int end) {
//     int mid = (start + end) / 2;
//     if (v[mid] > v[mid - 1] && v[mid] > v[mid + 1]) {
//         return mid;
//     }
//     else if (v[mid] < v[mid - 1]) {
//         return findPeak(v, start, mid - 1);
//     }
//     else {
//         return findPeak(v, mid + 1, end);
//     }
// }