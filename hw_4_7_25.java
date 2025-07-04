class BookNode:
    def __init__(self, title):
        self.title = title
        self.next = None

class BookQueue:
    def __init__(self):
        self.head = None

    def insert_at_front(self, title):
        new_node = BookNode(title)
        new_node.next = self.head
        self.head = new_node
        print(f"Inserted '{title}' at the front.")

    def insert_at_end(self, title):
        new_node = BookNode(title)
        if not self.head:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node
        print(f"Inserted '{title}' at the end.")

    def insert_at_position(self, title, position):
        new_node = BookNode(title)
        if position == 0:
            self.insert_at_front(title)
            return
        temp = self.head
        count = 0
        while temp and count < position - 1:
            temp = temp.next
            count += 1
        if not temp:
            print("Position out of bounds. Inserting at end.")
            self.insert_at_end(title)
            return
        new_node.next = temp.next
        temp.next = new_node
        print(f"Inserted '{title}' at position {position}.")

    def display_list(self):
        temp = self.head
        if not temp:
            print("Book queue is empty.")
            return
        print("Current Book Queue:")
        pos = 0
        while temp:
            print(f"{pos}: {temp.title}")
            temp = temp.next
            pos += 1

# Example usage
queue = BookQueue()

# Functional calls
queue.insert_at_end("General Book A")
queue.insert_at_front("Reference Book X")
queue.insert_at_position("Science Book Y", 2)
queue.insert_at_position("Engineering Book Z", 4)
queue.display_list()
