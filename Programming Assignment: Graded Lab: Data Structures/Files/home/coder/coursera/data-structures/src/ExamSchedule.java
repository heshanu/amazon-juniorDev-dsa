public class ExamSchedule {
    private ExamNode head;
    private ExamNode current;

    public ExamSchedule() {
        this.head = null;
        this.current = null;
    }

    public void addExam(String examDetails) {
        ExamNode examNode = new ExamNode(examDetails);
        // Check if the head is empty
        if (head == null) {
            // Assign the new node to the head and to the current node as well
            head = examNode;
        }
        else {
            // Traverse the linked list to find the last node
            ExamNode current = head;
            while (current.next != null) {
                // Move to the next node until the last node is found
                current = current.next;
            }
            // Link the last node's next reference to the new node
            current.next = examNode;
            // Link the new node's previous reference to the last node
            examNode.prev = current;

        }
        System.out.println("Exam added: " +examDetails);

        // TODO 2: Implement logic to add an exam to the end of the linked list
    }


    public void viewNextExam() {
        // TODO 3: Implement the logic to move to the next exam in the list and displays it
        if (current == null) {
            System.out.println("No exams available.");
        } else {
          //  ExamNode current = head;
            while (current.next != null) {
                current = current.next;
                System.out.print("Next Exam: "+current.examDetails + "");
            }
            System.out.println();
        }
    }


    public void viewPreviousExam() {
      //  ExamNode temp = head;
        if (current == null) {
            System.out.println("No exams available.");
        } else {
            if (current.prev != null) {
                current=current.prev;
                System.out.println("Previous Exam:."+current.examDetails);
            } else {

            }
        }
    }
        public void viewAllExamSchedule () {
            ExamNode temp = head;
            if (temp == null) {
                System.out.println("No exams scheduled.");
            } else {
                System.out.println("Exam Schedule:");
                while (temp != null) {
                    System.out.println(temp);
                    temp = temp.next;
                }
            }
        }
    }


