

class Reporter:
    HEADER = '''
\documentclass[]{scrartcl}

\usepackage{listings}
\usepackage{color}

% Title Page
\title{Language Framework for Optimal Schedulers (LFOS)}
\subtitle{Guideline for Users}
\author{G\"{u}ner Orhan}

\definecolor{mygreen}{rgb}{0,0.6,0}
\definecolor{backgroundcolor}{rgb}{1,1,0.95}
\definecolor{mygray}{rgb}{0.5,0.5,0.5}
\definecolor{mymauve}{rgb}{0.58,0,0.82}

\lstset{ %
	backgroundcolor=\color{backgroundcolor},	% choose the background color
	basicstyle=\footnotesize,        			% size of fonts used for the code
	breaklines=true,                 			% automatic line breaking only at whitespace
	captionpos=b,                    			% sets the caption-position to bottom
	commentstyle=\color{mygreen},    			% comment style
	escapeinside={\%*}{*)},          			% if you want to add LaTeX within your code
	keywordstyle=\color{blue},       			% keyword style
	stringstyle=\color{mymauve},    			% string literal style
	showspaces=false,                			% show spaces everywhere adding particular underscores; it overrides 'showstringspaces'
	showstringspaces=false,          			% underline spaces within strings only
	showtabs=false,                  			% show tabs within strings adding particular underscores
}

\begin{document}
\maketitle
    '''
    FOOTER = '''
\end{document}
    '''

    def __init__(self, filename):
        self.__file = open(filename, 'w')

    def accept(self, visitor):
        visitor.visit(self)

    def