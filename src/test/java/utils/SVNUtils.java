package utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNErrorCode;
import org.tmatesoft.svn.core.SVNErrorMessage;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.ISVNEditor;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.io.diff.SVNDeltaGenerator;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import org.tmatesoft.svn.core.wc2.SvnOperationFactory;
import org.tmatesoft.svn.core.wc2.SvnRemoteDelete;
import org.tmatesoft.svn.core.wc2.SvnTarget;

public class SVNUtils {
	public static String suiteDirectoryPath = "http://192.168.2.53:9880/Mobifin-Automation/branches/mobifin_5x_common_framework/mobifin_5x_common_framework/suites";
	public static String suiteFilePath = "http://192.168.2.53:9880/Mobifin-Automation/branches/mobifin_5x_common_framework/mobifin_5x_common_framework/suites/dynamic_suite1.xml";
	public static String userName = "dishant.doshi";
	public static String userPassword = "9k1m5AID";
	public static String commitFilePath = "C:\\Users\\badal.gandhi\\Desktop\\Dishant\\2-6\\Project\\mobifin_5x_dynamic_suite\\CheckOut\\suites\\DynamicSuite1.xml";

	public static void main(String[] args) throws IOException, SVNException {
		// setupLibrary();
		// commitExample(suiteDirectoryPath, suiteFilePath, commitFilePath);
		// removeFile();
		exportFromSvn(
				"http://192.168.2.53:9880/Mobifin-Automation/branches/mobifin_5x_common_framework/mobifin_5x_common_framework",
				"");
		// System.exit(0);
	}

	public static void commitFile(String suiteDirectoryPath, String suiteFilePath, String commitFilePath,
			byte[] oldContent, boolean isUpdate) throws IOException {
		File file = new File(commitFilePath);
		StringBuilder sb = new StringBuilder();
		FileInputStream fileStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileStream, StandardCharsets.UTF_8));
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + System.lineSeparator());
		}
		br.close();
		byte[] contents = new String(sb).getBytes();
		SVNURL url = null;
		SVNRepository repository = null;
		SVNNodeKind nodeKind = null;
		long latestRevision = 0;
		ISVNEditor editor = null;
		SVNCommitInfo commitInfo = null;
		try {
			url = SVNURL.parseURIEncoded(suiteDirectoryPath);
			repository = SVNRepositoryFactory.create(url);
			ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(userName,
					userPassword);
			repository.setAuthenticationManager(authManager);
			// System.out.println("The directory was deleted: " + commitInfo);
			nodeKind = repository.checkPath("", -1);
			if (nodeKind == SVNNodeKind.NONE) {
				SVNErrorMessage err = SVNErrorMessage.create(SVNErrorCode.UNKNOWN, "No entry at URL ''{0}''", url);
				throw new SVNException(err);
			} else if (nodeKind == SVNNodeKind.FILE) {
				SVNErrorMessage err = SVNErrorMessage.create(SVNErrorCode.UNKNOWN,
						"Entry at URL ''{0}'' is a file while directory was expected", url);
				throw new SVNException(err);
			}
			latestRevision = repository.getLatestRevision();
			System.out.println("Repository latest revision (before committing): " + latestRevision);
			editor = repository.getCommitEditor("directory and file added", null);
			if (isUpdate)
				commitInfo = modifyFile(editor, suiteFilePath, oldContent, contents);
			else
				commitInfo = addFile(editor, suiteFilePath, contents);
			System.out.println("The directory was added: " + commitInfo);
		} catch (SVNException e) {
			e.printStackTrace();
		}
	}

	private static SVNCommitInfo addFile(ISVNEditor editor, String filePath, byte[] data) throws SVNException {
		editor.openRoot(-1);
		// editor.addDir(dirPath, null, -1);
		editor.addFile(filePath, null, -1);
		editor.applyTextDelta(filePath, null);
		SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
		String checksum = deltaGenerator.sendDelta(filePath, new ByteArrayInputStream(data), editor, true);
		editor.closeFile(filePath, checksum);
		// editor.closeDir();
		// editor.closeDir();
		return editor.closeEdit();
	}

	public static void exportFromSvn(String svnurl, String destPath) {
		// final String destPath = ".\\CheckOut";
		try {
			SVNRepository repository = null;
			DAVRepositoryFactory.setup();
			repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svnurl));
			ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(userName,
					userPassword);
			repository.setAuthenticationManager(authManager);
			System.out.println("Repository Root: " + repository.getRepositoryRoot(true));
			System.out.println("Repository UUID: " + repository.getRepositoryUUID(true));
			long latestRevision = repository.getLatestRevision();
			System.out.println("Repository Latest Revision: " + latestRevision);
			SVNClientManager ourClientManager = SVNClientManager.newInstance();
			SVNUpdateClient updateClient = ourClientManager.getUpdateClient();
			updateClient.setIgnoreExternals(false);
			updateClient.doExport(repository.getLocation(), new File(destPath), SVNRevision.create(latestRevision),
					SVNRevision.create(latestRevision), null, true, true);
			System.out.println("Checkout file/folder successfully !");
			System.out.println("**************************************!");
		} catch (SVNException e) {
			System.out.println("Error message :" + e.getMessage());
			System.exit(1);
		}
	}

	public static SVNCommitInfo modifyFile(ISVNEditor editor, String filePath, byte[] oldData, byte[] newData)
			throws SVNException {
		editor.openRoot(-1);
		// editor.openDir(dirPath, -1);
		editor.openFile(filePath, -1);
		editor.applyTextDelta(filePath, null);
		SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
		String checksum = deltaGenerator.sendDelta(filePath, new ByteArrayInputStream(oldData), 0,
				new ByteArrayInputStream(newData), editor, true);
		editor.closeFile(filePath, checksum);
		// editor.closeDir();
		// editor.closeDir();
		return editor.closeEdit();
	}

	public static SVNCommitInfo deleteDir(ISVNEditor editor, String filePath) throws SVNException {
		editor.openRoot(-1);
		editor.deleteEntry(filePath, -1);
		editor.closeDir();
		return editor.closeEdit();
	}

	public static void removeFile() throws SVNException {
		SVNURL url = SVNURL.parseURIEncoded(suiteFilePath);
		SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
		try {
			final SvnRemoteDelete remoteDelete = svnOperationFactory.createRemoteDelete();
			remoteDelete.setSingleTarget(SvnTarget.fromURL(url));
			remoteDelete.setCommitMessage("Delete a file from the repository");
			final SVNCommitInfo commitInfo = remoteDelete.run();
			if (commitInfo != null) {
				final long newRevision = commitInfo.getNewRevision();
				System.out.println("Removed a file, revision " + newRevision + " created");
			}
		} finally {
			svnOperationFactory.dispose();
		}
	}

	public static SVNCommitInfo copyDir(ISVNEditor editor, String srcDirPath, String dstDirPath, long revision)
			throws SVNException {
		editor.openRoot(-1);
		editor.addDir(dstDirPath, srcDirPath, revision);
		editor.closeDir();
		editor.closeDir();
		return editor.closeEdit();
	}

	public static void setupLibrary() {
		DAVRepositoryFactory.setup();
		SVNRepositoryFactoryImpl.setup();
		FSRepositoryFactory.setup();
	}
}
