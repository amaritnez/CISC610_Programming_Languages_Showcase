# subprogram to modify numeric literal
sub modify_literal {
    # increase value by 1
    $_ += 1;
    print "Literal after modification: $_\n";
}
# pass the literal by reference to the subprogram
modify_literal(42);

# subprogram to modifies string literal parameter
sub modify_parameter {
    # change value of string
    $_[0] = "modified";
    print $_;
}
# pass the literal by reference to the subprogram
modify_parameter("original");
# print the result
