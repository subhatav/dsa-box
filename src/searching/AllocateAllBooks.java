package searching;

// Problem Link: https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574
// Solution Link: https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/

// Approach: Binary Search & Placing Technique; Time Complexity: O(NlogN)

public class AllocateAllBooks {

    public long compute(int[] books, int shelves) {

        long low = 0, high = 0, optimal = -1;

        // Calculate the TOTAL Number of Pages
        for (int book : books) { high += book; }

        while (low <= high) {

            long mid = low + (high - low) / 2;

            // MINIMIZE the OPTIMAL Pages
            if (place(books, shelves, mid)) {

                optimal = mid;
                high = mid - 1;

            } else low = mid + 1;
        }

        return optimal;
    }

    private boolean place(int[] books, int shelves, long max) {

        long pages = 0; // Save number of PAGES in CURRENT Shelf
        int count = 1; // Start placing Books in the FIRST Shelf

        for (int book : books) {

            // Check if the CURRENT Book
            // is GREATER than the "max"
            if (book > max) return false;

            // Place the Book, if the
            // CURRENT Shelf can HOLD
            // i.e. MAXIMIZE the Slot
            if (pages + book > max) {

                count += 1; // Switch to NEW Shelf

                // Exit if MORE Shelves are NEEDED
                if (count > shelves) return false;

                pages = book;

            } else pages += book;
        }

        return true;
    }
}