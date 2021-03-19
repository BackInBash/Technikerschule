;
; LEDLauflicht.asm
;
; Created: 19/03/2021 13:45:34
; Author : Markus
;


; Replace with your application code
.INCLUDE    "m16def.inc"

init:
	LDI R18, 1
	LDI R17, 0xff
	out DDRA, R17

main:
	out PORTA, R18
	ADD R18, R18
	CBI PORTA, 0
	jmp main
