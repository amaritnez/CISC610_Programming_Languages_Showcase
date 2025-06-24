# Online Ruby Compiler (Interpreter)

# Base class SingleLinkedList
class SingleLinkedList
    class Node
      attr_accessor :link, :contents
    end
  
    def initialize
      @head = nil
    end
  
    def insert_at_head(value)
      node = Node.new
      node.contents = value
      node.link = @head
      @head = node
    end
  
    def insert_at_tail(value)
      node = Node.new
      node.contents = value
      if @head.nil?
        @head = node
      else
        tail_node = @head
        tail_node = tail_node.link until tail_node.link.nil?
        tail_node.link = node
      end
    end
  
    def remove_at_head
      raise 'List is empty' if @head.nil?
      node = @head
      @head = @head.link
      node.contents
    end
  
    def is_empty
      @head.nil?
    end
  end
  
  # Stack2 which extends SingleLinkedList
  class Stack2 < SingleLinkedList
    def push(value)
      insert_at_head(value)
    end
  
    def pop
      remove_at_head
    end
  
    def is_empty
      super
    end
  end
  
  # Queue2 which extends SingleLinkedList
  class Queue2 < SingleLinkedList
    def enqueue(value)
      insert_at_tail(value)
    end
  
    def dequeue
      remove_at_head
    end
  
    def is_empty
      super
    end
  end