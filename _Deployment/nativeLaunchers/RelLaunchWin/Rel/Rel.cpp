// Rel native launcher for Windows.

#include "pch.h"
#include <iostream>
#include <cstdlib>
#include <direct.h>

int main(int argc, char **argv)
{
	_chdir(argv[0]);
	system("jre\\bin\\java -splash:Splash.png -cp \"lib\\*;lib\\nattable\\*;lib\\swt\\*;lib\\swt\\win_64\\*\" DBrowser ");
}