push lab0
lfp
push 1
lfp
lfp
push 1
sub
lw
js
print
halt
lab1:
cfp
lra
lfp
lw
push -1
sub
lw
lfp
push -1
sub
lw
add
srv
sra
pop
pop
sfp
lrv
lra
js
lab0:
cfp
lra
push lab1
lfp
push 0
lfp
lfp
push 2
sub
lw
js
push 1
beq lab2
push 1
b lab3
lab2:
push 0
lab3:
print
halt
lab1:
cfp
lra
lfp
lw
push -1
sub
lw
lfp
push -1
sub
lw
add
srv
sra
pop
pop
sfp
lrv
lra
js
srv
sra
pop
pop
sfp
lrv
lra
js
