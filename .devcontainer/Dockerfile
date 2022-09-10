ARG VARIANT="3.15"
FROM mcr.microsoft.com/vscode/devcontainers/base:0-alpine-${VARIANT}

WORKDIR /home/app

ARG TARGET_JAVA_VERSION="17.0.4"
ENV JAVA_HOME /usr/lib/jvm/msopenjdk-${TARGET_JAVA_VERSION}
ENV PATH "${JAVA_HOME}/bin:${PATH}"
ENV LANG en_US.UTF-8

ARG JDK="https://aka.ms/download-jdk/microsoft-jdk-${TARGET_JAVA_VERSION}-alpine-x64.tar.gz"
RUN wget --progress=dot:giga -O msopenjdk.tar.gz "${JDK}" \
	&& wget --progress=dot:giga -O sha256sum.txt "${JDK}.sha256sum.txt" \
	\
	&& sha256sumText=$(cat sha256sum.txt) \
	&& sha256=$(expr substr "${sha256sumText}" 1 64) \
	&& echo "${sha256} msopenjdk.tar.gz" | sha256sum --strict --check - \
	&& rm sha256sum.txt* \
	\
	&& mkdir -p "$JAVA_HOME" \
	&& tar --extract \
		--file msopenjdk.tar.gz \
		--directory "$JAVA_HOME" \
		--strip-components 1 \
		--no-same-owner \
	&& rm msopenjdk.tar.gz* \
	\
	&& ln -s ${JAVA_HOME} /docker-java-home \
	&& ln -s ${JAVA_HOME} /usr/local/openjdk-${TARGET_JAVA_VERSION}

# [Option] Install Maven
ARG INSTALL_MAVEN="false"
ARG MAVEN_VERSION=""
RUN if [ "${INSTALL_MAVEN}" = "true" ]; then su vscode -c "umask 0002 && . /usr/local/sdkman/bin/sdkman-init.sh && sdk install maven \"${MAVEN_VERSION}\""; fi
