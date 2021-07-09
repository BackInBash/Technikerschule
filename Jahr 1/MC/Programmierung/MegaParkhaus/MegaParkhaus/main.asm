; MegaParkhaus.asm
;
; Created: 02.07.2021 14:08:49
; Author : simon.stadtmueller
;
.INCLUDE "m16def.inc"

init:

	;R16 -> Initialisierungsregister
	ldi R16, 0xff

	;PORTA als AusgabePort
	out DDRA, R16

	;PORTB als EingabePort
	ldi R16, 0x00
	out DDRD, R16

	;PORTA null setzen (Weil pullup auf port A bei atmega16 aktiviert default)
	out PORTA, R16

	; Set Global Register
	ldi R20, 0b00000000 ; Geschlossen
	ldi R21, 0b00000000 ; Abgasalarm
	ldi R22, 0b00000000 ; Belegt
	
main:
	; Geschlossen Einlesen
	in R20, PIND
	andi R20, 0b00000100
	; Abgasalarm Einlesen
	in R21, PIND
	andi R21, 0b00001000 
	; Belegt Berechnen
	andi R22, 0xF
	brbc 1, einfahrt
	rjmp main

einfahrt:
	ldi R17, 0x00 ; Set Local 
	in R17, PINA  ; Load Value PINA

	; TasterEinfahrtZuweisung
	; R17 0bX0000000
	andi R17, 0b10000000
	
	subi R17, R20 ; Einfahrt - Geschlossen
	brbc 1, R17

	; LichtschrankeEinfahrtZuwesiung
	; R17 0b0X000000
	andi R17, 0b01000000


	TasterEinfahrt:

	istGeschlossen:

ausfahrt:

