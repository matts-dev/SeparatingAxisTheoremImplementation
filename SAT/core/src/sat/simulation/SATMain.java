package sat.simulation;

import java.util.Arrays;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;

public class SATMain extends ApplicationAdapter
{
	private ShapeRenderer shapeRenderer;
	private Polygon square;
	private Polygon triangle;
	private float translationSpeed = 10f;
	private float rotationSpeed = 10f;

	@Override
	public void create()
	{
		shapeRenderer = new ShapeRenderer();
		//square @formatter:off
		float[] squareVerts = new float[] { 
			5f, 5f,
			10f, 5f,
			10f, 0f,
			5f, 0f
		};
		square = new Polygon(squareVerts);
		square.setOrigin(7.5f, 2.5f);
		
		//triangle
		float[] triangleVerts = new float[]{
			50f, 50f,
			55f, 55f,
			60f, 50f
		}; //@formatter:on
		triangle = new Polygon(triangleVerts);
		triangle.setOrigin(55f, 52.5f);

		configureShapesInitialTransformations();
	}

	private void configureShapesInitialTransformations()
	{
		// scaling
		triangle.scale(10);
		square.scale(10);

		// position
		triangle.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	}

	@Override
	public void render()
	{
		keyboard_io();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.setAutoShapeType(true);
		shapeRenderer.begin();
		shapeRenderer.polygon(square.getTransformedVertices());
		shapeRenderer.polygon(triangle.getTransformedVertices());
		shapeRenderer.end();
	}

	private void keyboard_io()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT) || Gdx.input.isKeyPressed(Input.Keys.CONTROL_RIGHT))
		{
			// ROTATE SQUARE
			if (Gdx.input.isKeyPressed(Input.Keys.W))
			{
				square.setRotation(square.getRotation() - rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.A))
			{
				square.setRotation(square.getRotation() + rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.D))
			{
				square.setRotation(square.getRotation() - rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.S))
			{
				square.setRotation(square.getRotation() + rotationSpeed);
			}

			// ROTATE TRIANGLE
			if (Gdx.input.isKeyPressed(Input.Keys.UP))
			{
				triangle.setRotation(triangle.getRotation() - rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			{
				triangle.setRotation(triangle.getRotation() + rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			{
				triangle.setRotation(triangle.getRotation() - rotationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			{
				triangle.setRotation(triangle.getRotation() + rotationSpeed);
			}
		}
		else
		{
			// MOVE SQUARE
			if (Gdx.input.isKeyPressed(Input.Keys.W))
			{
				square.translate(0, translationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.A))
			{
				square.translate(-translationSpeed, 0);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.D))
			{
				square.translate(translationSpeed, 0);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.S))
			{
				square.translate(0, -translationSpeed);
			}

			// MOVE TRIANGLE
			if (Gdx.input.isKeyPressed(Input.Keys.UP))
			{
				triangle.translate(0, translationSpeed);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
			{
				triangle.translate(-translationSpeed, 0);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			{
				triangle.translate(translationSpeed, 0);
			}
			else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
			{
				triangle.translate(0, -translationSpeed);
			}
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
		{
			Gdx.app.exit();
		}
	}

	@Override
	public void dispose()
	{
		shapeRenderer.dispose();
	}
}
