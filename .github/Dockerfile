FROM ghcr.io/readon/spinalhdl:master

ARG JAVA_EXTRA_OPTS="-Xmx2g -Xms2g"
ENV JAVA_OPTS="${JAVA_OPTS} ${JAVA_EXTRA_OPTS}"
RUN git clone https://github.com/SpinalHDL/SpinalTemplateSbt.git && \ 
    cd SpinalTemplateSbt && \
    git submodule update --init --recursive && \
    sbt compile && \
    mill _.compile && \
    cd .. && rm -rf SpinalTemplateSbt
