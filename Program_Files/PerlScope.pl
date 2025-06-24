use warnings;
# global variable
my $global_var = 10;

# static scoping function
sub static_scoping {
    # local variable
    local $local_var = 5;
    # change global variable
    $global_var = 20;
    # print variables
    print "Static scoping:\n";
    print "Local variable: $local_var\n";
    print "Global variable: $global_var\n";
}

# dynamic scoping function
sub dynamic_scoping {
    # change global variable
    $global_var = 30;
    # print variables
    print "Dynamic scoping:\n";
    # This will fail because perl dynamic scoping will not save local_var in this function
    print "Local variable: $local_var\n";
    print "Global variable: $global_var\n";
}

# main program
print "Global variable: $global_var\n\n";
# show static scoping first
static_scoping();
print "\n";
# show dynamic scoping next
dynamic_scoping();
print "\n";
print "After function calls:\n";
print "Global variable: $global_var\n";