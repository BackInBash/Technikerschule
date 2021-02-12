;
; HelloASM.asm
;
; Created: 12/02/2021 15:31:56
; Author : Markus
;

ldi r16, 0b00000111
ldi r22, 0x15

; Replace with your application code

ldi r17, 0x1
ldi r18, 0x1
ldi r19, 0x0


start:
    inc r16
	mov r17, r18
	add r18, r19
    rjmp start
